# evtjs-android-demo
Demo application which shows how to interact with evtjs in android environment.

## Build and run
Use `Android Studio` to open and build this demo.

## Key points
1. Please update `evtjs` version before your use.
2. Use WebView to call javascript codes.
3. For `async` function, register a java method as a callback to receive the result. Please refer to `@JavascriptInterface` related documentation of android.
4. You need a bridge html file between `evtjs` and `android` side. This file is located at `assets` folder. This is only a demo, you should change it and add more functions.
5. The bridge should handle as much as it can to reduce the times of the call between `java` and `js` because it is slow. Please refer to the comments and codes of `app\src\main\assets\index.html`.

