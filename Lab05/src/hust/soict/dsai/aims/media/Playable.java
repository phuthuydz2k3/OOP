package hust.soict.dsai.aims.media;

import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.exception.TrackException;

public interface Playable
{
    public abstract void play() throws PlayerException, TrackException;
}
