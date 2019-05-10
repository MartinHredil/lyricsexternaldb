package ayds.spotisong.terminus.otherdetails.model.lyricsrepository.external.lyricsserver;

import ayds.spotisong.terminus.otherdetails.model.lyricsrepository.external.Lyrics;
import ayds.spotisong.terminus.otherdetails.model.lyricsrepository.external.ExternalLyricsService;
import ayds.spotisong.terminus.otherdetails.model.lyricsrepository.external.LyricsSong;
import ayds.spotisong.terminus.song.model.Song;
import retrofit2.Response;

class ExternalLyricsServiceImp implements ExternalLyricsService {

    private LyricsAPI lyricsAPI;
    private ServerToLyricsResolver serverToLyricsResolver;


    ExternalLyricsServiceImp(ServerToLyricsResolver serverToLyricsResolver,LyricsAPI lyricsAPI){
        this.serverToLyricsResolver=serverToLyricsResolver;
        this.lyricsAPI=lyricsAPI;
    }

    public Lyrics getLyrics(LyricsSong song) throws Exception {
        Response<String> callResponse = getLyricsFromService(song);
        return serverToLyricsResolver.getLyricsFromExternalData(callResponse.body());
    }

    private Response<String> getLyricsFromService(LyricsSong song) throws Exception{
        return lyricsAPI.getLyrics(song.getArtistName(), song.getSongName()).execute();
    }
}
