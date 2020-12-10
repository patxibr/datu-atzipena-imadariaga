package model;

public class Track {

    int TrackId;
    String Name;
    int AlbumId;
    int MediaTypeId;
    int GenreId;
    String Composer;
    int Milliseconds;
    int Bytes;
    float UnitPrice;

    public Track() {
    }

    public Track(int TrackId, String Name, int AlbumId, int MediaTypeId, int GenreId, String Composer, int Milliseconds, int Bytes, float UnitPrice) {
        this.TrackId = TrackId;
        this.Name = Name;
        this.AlbumId = AlbumId;
        this.MediaTypeId = MediaTypeId;
        this.GenreId = GenreId;
        this.Composer = Composer;
        this.Milliseconds = Milliseconds;
        this.Bytes = Bytes;
        this.UnitPrice = UnitPrice;
    }

    public int getTrackId() {
        return TrackId;
    }

    public String getName() {
        return Name;
    }

    public int getAlbumId() {
        return AlbumId;
    }

    public int getMediaTypeId() {
        return MediaTypeId;
    }

    public int getGenreId() {
        return GenreId;
    }

    public String getComposer() {
        return Composer;
    }

    public int getMilliseconds() {
        return Milliseconds;
    }

    public int getBytes() {
        return Bytes;
    }

    public float getUnitPrice() {
        return UnitPrice;
    }

    public void setTrackId(int TrackId) {
        this.TrackId = TrackId;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setAlbumId(int AlbumId) {
        this.AlbumId = AlbumId;
    }

    public void setMediaTypeId(int MediaTypeId) {
        this.MediaTypeId = MediaTypeId;
    }

    public void setGenreId(int GenreId) {
        this.GenreId = GenreId;
    }

    public void setComposer(String Composer) {
        this.Composer = Composer;
    }

    public void setMilliseconds(int Milliseconds) {
        this.Milliseconds = Milliseconds;
    }

    public void setBytes(int Bytes) {
        this.Bytes = Bytes;
    }

    public void setUnitPrice(float UnitPrice) {
        this.UnitPrice = UnitPrice;
    }

    @Override
    public String toString() {
        return "Track{"
                + "TrackId=" + TrackId + ", Name=" + Name + ", AlbumId="+ AlbumId
                + ", MediaTypeId=" + MediaTypeId + ", GenreId=" + GenreId
                + ", Composer=" + Composer + ", Milliseconds=" + Milliseconds
                + ", Bytes=" + Bytes + ", UnitPrice=" + UnitPrice + "}";
    }
}
