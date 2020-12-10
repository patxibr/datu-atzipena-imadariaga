package model;

public class Album {

    int AlbumId;
    String Title;
    int ArtistId;

    public Album() {
    }

    public Album(int AlbumId, String Title, int ArtistId) {
        this.AlbumId = AlbumId;
        this.Title = Title;
        this.ArtistId = ArtistId;
    }

    public int getAlbumId() {
        return AlbumId;
    }
    
    public String getTitle(){
        return Title;
    }
    
    public int getArtistId(){
        return ArtistId;
    }

    public void setAlbumId(int AlbumId) {
        this.AlbumId = AlbumId;
    }
    
    public void setTitle(String Title){
        this.Title = Title;
    }
    
    public void setArtistId(int ArtistId){
        this.ArtistId = ArtistId;
    }

    @Override
    public String toString() {
        return "Track{"
                + "AlbumId="+ AlbumId
                + ", Title=" + Title
                + ", ArtistId="+ ArtistId
                + "}";
    }
}
