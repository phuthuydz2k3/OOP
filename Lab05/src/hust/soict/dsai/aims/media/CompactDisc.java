package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable
{
    private String artist;
    private ArrayList<Track> tracks;

    public CompactDisc(String title, String category, float cost
            , int length, String director, String artist, ArrayList<Track> tracks)
    {
        super(title, category, cost, length, director);
        setArtist(artist);
        setTracks(tracks);
    }

    @Override
    public void play()
    {
        for (Track track : tracks)
        {
            track.play();
        }
    }

    @Override
    public String toString()
    {
        String initialString = "{ \"Id\": \"" + this.getId() + "\" ,"
                + "\"Title\": \"" + this.getTitle() + "\", "
                + "\"Category\": \"" + this.getCategory() + "\", "
                + "\"Cost\": \"" + this.getCost() + "\", "
                + "\"Artist\": \"" + this.artist + "\", ";

        StringBuilder stringBuilder = new StringBuilder(initialString);
        if (tracks != null)
        {
            for (Track track : tracks)
            {
                stringBuilder.append("\"" + track.getTitle() + "\", ");
            }
        }
        stringBuilder.append(" }");

        return stringBuilder.toString();
    }

    public void addTrack(Track track)
    {
        if (!tracks.contains(track))
        {
            tracks.add(track);
        }
    }

    public void removeTrack(Track track)
    {
        if (tracks.contains(track))
        {
            tracks.remove(track);
        }
    }

    public int getLength()
    {
        int totalLength = 0;

        for (Track track : tracks)
        {
            totalLength += track.getLength();
        }

        return totalLength;
    }

    public void setTracks(ArrayList<Track> tracks) {
        this.tracks = tracks;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
