# New-Frontier-Craft
A new adventure in old Minecraft.

Git client build: 1.8.6 Dev. 01 (UNSTABLE) (NO SERVER YET)

Setup: Obtain MCP 43 and a Beta 1.7.3 minecraft.jar and decompile the jar. Then download this into your file containing MCP files. Locate and/or download Mojang's most recent authlib. I can find it in my minecraft directory\libraries\com\mojang\authlib\(Most recent version here). Copy that into the lib folder with your MCP files. I cannot distribute that for legal reasons.

The rest of the setup is for eclipse users. Copy the images in the Images file into eclipse\Client\bin. If the images break ingame, do this process again. It usually does not happen unless you are recompiling (Currently I have not made a better system yet). Setup eclipse for MCP. Add all of the jars in lib to your refernced libraries. You should be able to run and play NFC now!

If you are not using eclipse, why?

NOTES: The current state of NFC's source is MOSTLY POOR. 99% of the code is not commented. The plan is to get the new methods and the original methods in modified classes fully commented, and also state what has changed in the classes. There are still a lot of methods that have terrible names like "func_98409128" from MCP 43 not having fully decompiled Beta. Hopefully we can improve this with time too.
