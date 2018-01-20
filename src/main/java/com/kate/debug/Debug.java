package com.kate.debug;

public class Debug {
    private static DebugListener  debugListener = null;

    public static DebugListener getDebugListener() {
        return debugListener;
    }

    public static void setDebugListener(DebugListener debugListener) {
        Debug.debugListener = debugListener;
    }
    
    public static void print(String flag, String str) {
        if (flag.equalsIgnoreCase("r")) {
            System.err.println(str);
        }
        else {
            System.out.println(str);
        }
        if (debugListener != null) {
            debugListener.print(flag, str);
        }
    }
}
