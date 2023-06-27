package hust.soict.dsai.aims.media;

public class Track implements Playable
{
    private String title;
    private int length;

    public Track(String title, int length)
    {
        setTitle(title);
        setLength(length);
    }

    public void play()
    {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }

    @Override
    public boolean equals(Object obj)
    {
        Track track = (Track) obj;
        return this.title.equals(track.title) && this.getLength() == track.getLength();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
