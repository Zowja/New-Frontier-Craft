package net.minecraft.src;

import java.io.IOException;
import java.net.*;

class ThreadPollServers extends Thread
{
    final ServerNBTStorage server;
    final GuiSlotServer serverSlotContainer;

    ThreadPollServers(GuiSlotServer guislotserver, ServerNBTStorage servernbtstorage)
    {
        serverSlotContainer = guislotserver;
        server = servernbtstorage;
    }

    public void run()
    {
        try
        {
            server.motd = "\2478Polling..";
            long l = System.nanoTime();
            GuiMultiplayer.pollServer(serverSlotContainer.field_35410_a, server);
            long l1 = System.nanoTime();
            server.lag = (l1 - l) / 0xf4240L;
        }
        catch (UnknownHostException unknownhostexception)
        {
            server.lag = -1L;
            server.motd = "\2474Can't resolve hostname";
        }
        catch (SocketTimeoutException sockettimeoutexception)
        {
            server.lag = -1L;
            server.motd = "\2474Can't reach server";
        }
        catch (ConnectException connectexception)
        {
            server.lag = -1L;
            server.motd = "\2474Can't reach server";
        }
        catch (IOException ioexception)
        {
            server.lag = -1L;
            server.motd = "\2474Communication error";
        }
        catch (Exception exception)
        {
            server.lag = -1L;
            server.motd = (new StringBuilder()).append("ERROR: ").append(exception.getClass()).toString();
        }
        finally
        {
            synchronized (GuiMultiplayer.getLock())
            {
                GuiMultiplayer.decrementThreadsPending();
            }
        }
    }
}
