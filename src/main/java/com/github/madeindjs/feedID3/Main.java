package com.github.madeindjs.feedID3;

import com.mpatric.mp3agic.ID3v24Tag;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.NotSupportedException;
import com.mpatric.mp3agic.UnsupportedTagException;
import java.io.IOException;
import java.net.MalformedURLException;

public class Main {

    public static void main(String[] args) throws IOException, UnsupportedTagException, InvalidDataException, NotSupportedException, MalformedURLException, DiscogConsumerNotSetException {
        Discog.CONSUMER_KEY = "<YOUR_CONSUMER_KEY>";
        Discog.CONSUMER_SECRET = "<YOUR_CONSUMER_SECRET>";

        // Open file
        MyMp3File file = new MyMp3File("src/test/resources/empty.mp3");
        // fetch informations from Discog API
        file.getInformations();
        // read information fetched
        ID3v24Tag id3 = file.getNewID3();
        System.out.println(String.format("New artist: %s", id3.getArtist()));
        // overwide file
        file.update();
    }

}
