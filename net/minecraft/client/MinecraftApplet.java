// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.client;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.io.PrintStream;
import java.net.URL;
import net.minecraft.src.*;

// Referenced classes of package net.minecraft.client:
//            Minecraft

public class MinecraftApplet extends Applet {

	public MinecraftApplet() {
		mcThread = null;
	}

	public void init() {
		mcCanvas = new CanvasMinecraftApplet(this);
		boolean flag = false;
		if (getParameter("fullscreen") != null) {
			flag = getParameter("fullscreen").equalsIgnoreCase("true");
		}
		mc = new MinecraftAppletImpl(this, this, mcCanvas, this, getWidth(),
				getHeight(), flag);
		mc.minecraftUri = getDocumentBase().getHost();
		if (getDocumentBase().getPort() > 0) {
			mc.minecraftUri += ":" + getDocumentBase().getPort();
		}
		if (getParameter("username") != null
				&& getParameter("sessionid") != null) {
			mc.session = new Session(getParameter("username"),
					getParameter("sessionid"), getParameter("uuid"));
			System.out.println((new StringBuilder()).append(": ")
					.append(mc.session.username).append(", ")
					.append(mc.session.token).toString());
			if (getParameter("mppass") != null) {
				mc.session.mpPassParameter = getParameter("mppass");
			}
		} else {
			mc.session = new Session("Player", "", "");
		}
		if (getParameter("server") != null && getParameter("port") != null) {
			mc.setServer(getParameter("server"),
					Integer.parseInt(getParameter("port")));
		}
		mc.hideQuitButton = true;
		setLayout(new BorderLayout());
		add(mcCanvas, "Center");
		mcCanvas.setFocusable(true);
		validate();
		return;
	}

	public void startMainThread() {
		if (mcThread != null) {
			return;
		} else {
			mcThread = new Thread(mc, "Minecraft main thread");
			mcThread.start();
			return;
		}
	}

	public void start() {
		if (mc != null) {
			mc.isGamePaused = false;
		}
	}

	public void stop() {
		if (mc != null) {
			mc.isGamePaused = true;
		}
	}

	public void destroy() {
		shutdown();
	}

	public void shutdown() {
		if (mcThread == null) {
			return;
		}
		mc.shutdown();
		try {
			mcThread.join(10000L);
		} catch (InterruptedException interruptedexception) {
			try {
				mc.shutdownMinecraftApplet();
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}
		mcThread = null;
	}

	public void clearApplet() {
		mcCanvas = null;
		mc = null;
		mcThread = null;
		try {
			removeAll();
			validate();
		} catch (Exception exception) {
		}
	}

	private Canvas mcCanvas;
	private Minecraft mc;
	private Thread mcThread;
}
