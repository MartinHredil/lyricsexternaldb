package ayds.spotisong.terminus.otherdetails.model.lyricsrepository.external.lyricsserver;

import ayds.spotisong.terminus.otherdetails.model.lyricsrepository.external.Lyrics;

public interface ServerToLyricsResolver {

    Lyrics getLyricsFromExternalData(String serviceData) throws Exception;
}
