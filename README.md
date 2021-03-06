# osureader
A small java library for parsing the osu beatmap file format (.osu)

Please reference [this wiki page](https://osu.ppy.sh/help/wiki/osu!_File_Formats/Osu_(file_format)) for more information on the osu file format.

## Getting it

If you're using gradle:
```gradle
repositories {
    ...
    maven { url 'https://jitpack.io' }
}

dependencies {
    ...
    implementation 'com.github.zeroeightysix:osureader:-SNAPSHOT'
}
```
With maven:
```xml
<repositories>
  <repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
  </repository>
</repositories>

<dependency>
  <groupId>com.github.zeroeightysix</groupId>
  <artifactId>osureader</artifactId>
  <version>-SNAPSHOT</version>
</dependency>
```

## Usage:
To parse a file: 
```java
import me.zeroeightysix.osureader.OsuFile;
import me.zeroeightysix.osureader.OsuReader;

File myFile = new File("myFile.osu");
OsuFile osuFile = OsuReader.read(myFile);
```
Be wary: this might throw a `OsuParseException`.

To access information, use any of the `getSectionName` methods (e.g. `getGeneral`) which return a class representing the requested section.
For example:
```java
GeneralSection general = osuFile.getGeneral();
System.out.println(String.format("The audio filename is %s and the beatmap starts at %dms.", general.getAudioFilename(), general.getAudioLeadIn()));
```
Be careful though: These will once again further extract data from the already-parsed osu file, converting them into easy-to-use objects.

That means: repeatedly calling `getGeneral` or any methods alike will likely be performance-heavy. The `OsuParseException` might be thrown if there is missing or incorrect data.
