java -jar tools\apktool.jar b -f -o doodle_new.apk DoodleDecompiled
jarsigner -verbose -sigalg SHA1withRSA -digestalg SHA1 -keystore my-release-key.keystore -storepass "123456" doodle_new.apk doodle
pause