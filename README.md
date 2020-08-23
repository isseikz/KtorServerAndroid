# KtorServerAndroid
An example for kotlin server project with Ktor on Android 

## Setup

`build.gradle (:project)`
```
buildscript {
    ext.kotlin_version = "1.3.72"
    ext.ktor_version = "1.4.0"
    
    ...
    
```


`build.gradle (:app)`
```
dependencies { // Add three dependencies below:
    implementation "io.ktor:ktor-server-core:$ktor_version"
    implementation "io.ktor:ktor-server-jetty:$ktor_version"
    implementation "ch.qos.logback:logback-classic:1.2.3"
}

```

`AndroidManifest.xml`
```
// Add a permission "android.permission.INTERNET"
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.example.ktorexample">

    <uses-permission android:name="android.permission.INTERNET" />

    <application
        android:allowBackup="true"
        ...
```


## Server

`KtorServerObject.kt`
```
object KtorServerObject {
    internal fun start(port: Int = 8080) {
        embeddedServer(Jetty, port) {
            routing {
                // Write what you want...
                get("/") {
                    call.respondText("Hello", ContentType.Text.Html)
                }
            }
        }.start(wait = true)
    }
}
```

`MainActivity.kt`
```
override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.Default).launch {
            KtorServerObject.start()
        }
    }
```
