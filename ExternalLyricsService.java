package ayds.spotisong.terminus.otherdetails.model.lyricsrepository.external;

public interface ExternalLyricsService {

    Lyrics getLyrics(LyricsSong song) throws Exception;
}
