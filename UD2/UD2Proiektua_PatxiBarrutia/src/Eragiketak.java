
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;
import model.Album;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Track;
import org.hibernate.HibernateException;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Transaction;

public class Eragiketak {

    public static SessionFactory sf = new Configuration().configure().buildSessionFactory();

    public static void main(String[] args) {
        int i = 10;
        String s = "";
        Scanner in = new Scanner(System.in);
        System.out.println("Programa hasi da!");
        while (i != 0) {
            System.out.println("Aukeratu zer egin nahi duzun:");
            System.out.println("1) 'Track' taula ikusi");
            System.out.println("2) 'Track' taulan datu berri bat gorde");
            System.out.println("3) 'Track' taulako datu bat aldatu");
            System.out.println("4) 'Track' taulatik datu bat ezabatu");
            System.out.println("5) 'Album' taula ikusi");
            System.out.println("6) 'Album' taulan datu berri bat gorde");
            System.out.println("7) 'Album' taulako datu bat aldatu");
            System.out.println("8) 'Album' taulatik datu bat ezabatu");
            System.out.println("9) 'Track' eta 'Album' taulak ikusi");
            System.out.println("0) Programa amaitu");
            try {
                i = in.nextInt();
                switch (i) {
                    case 1:
                        datuakIkusiTrack();
                        break;
                    case 2:
                        trackInsertKasua();
                        break;
                    case 3:
                        trackUpdateKasua();
                        break;
                    case 4:
                        trackDeleteKasua();
                        break;
                    case 5:
                        datuakIkusiAlbum();
                        break;
                    case 6:
                        albumInsertKasua();
                        break;
                    case 7:
                        albumUpdateKasua();
                        break;
                    case 8:
                        albumDeleteKasua();
                        break;
                    case 9:
                        datuakIkusiTrackAlbum();
                    case 0:
                        System.out.println("Programa amaitu da!");
                        break;
                    default:
                        System.out.println("Aukera hori ez da existitzen!");
                        break;
                }
            } catch (Exception ex) {
                System.out.println("Zenbaki bat aukeratu mesedez!");
            }
        }

    }

    public static void trackInsertKasua() {
        int TrackId, AlbumId, MediaTypeId, GenreId, Milliseconds, Bytes;
        String Name, Composer;
        float UnitPrice;
        Scanner in = new Scanner(System.in);
        try {
            System.out.print("Idatzi Track berriaren TrackId: ");
            TrackId = in.nextInt();
            System.out.print("Idatzi Track berriaren Name: ");
            Name = in.next();
            System.out.print("Idatzi Track berriaren AlbumId: ");
            AlbumId = in.nextInt();
            System.out.print("Idatzi Track berriaren MediaTypeId: ");
            MediaTypeId = in.nextInt();
            System.out.print("Idatzi Track berriaren GenreId: ");
            GenreId = in.nextInt();
            System.out.print("Idatzi Track berriaren Composer: ");
            Composer = in.next();
            System.out.print("Idatzi Track berriaren Milliseconds: ");
            Milliseconds = in.nextInt();
            System.out.print("Idatzi Track berriaren Bytes: ");
            Bytes = in.nextInt();
            System.out.print("Idatzi Track berriaren UnitPrice: ");
            UnitPrice = in.nextFloat();
            datuaGordeTrack(new Track(TrackId, Name, AlbumId, MediaTypeId, GenreId, Composer, Milliseconds, Bytes, UnitPrice));
        } catch (Exception ex) {
            System.out.println("Daturen bat gaizki sartu duzu!");
        }
    }

    public static void trackUpdateKasua() {
        int TrackId, AlbumId, MediaTypeId, GenreId, Milliseconds, Bytes;
        String Name, Composer;
        float UnitPrice;
        Scanner in = new Scanner(System.in);
        try {
            System.out.print("Idatzi aldatu nahi duzun Track-aren TrackId: ");
            TrackId = in.nextInt();
            System.out.print("Idatzi Track-aren Name berria: ");
            Name = in.next();
            System.out.print("Idatzi Track-aren  AlbumId berria: ");
            AlbumId = in.nextInt();
            System.out.print("Idatzi Track-aren MediaTypeId berria: ");
            MediaTypeId = in.nextInt();
            System.out.print("Idatzi Track-aren GenreId berria: ");
            GenreId = in.nextInt();
            System.out.print("Idatzi Track-aren Composer berria: ");
            Composer = in.next();
            System.out.print("Idatzi Track-aren Milliseconds berria: ");
            Milliseconds = in.nextInt();
            System.out.print("Idatzi Track-aren Bytes berria: ");
            Bytes = in.nextInt();
            System.out.print("Idatzi Track-aren UnitPrice berria: ");
            UnitPrice = in.nextFloat();
            datuaAldatuTrack(TrackId, Name, AlbumId, MediaTypeId, GenreId, Composer, Milliseconds, Bytes, UnitPrice);
        } catch (Exception ex) {
            System.out.println("Daturen bat gaizki sartu duzu!");
        }
    }

    public static void trackDeleteKasua() {
        int i;
        Scanner in = new Scanner(System.in);
        try {
            System.out.print("Idatzi ezabatu nahi duzun Track-aren TrackId: ");
            i = in.nextInt();
            datuaEzabatuTrack(i);
        } catch (Exception ex) {
            System.out.println("Datua gaizki sartu duzu!");
        }
    }

    public static void albumInsertKasua() {
        int AlbumId, ArtistId;
        String Title;
        Scanner in = new Scanner(System.in);
        try {
            System.out.print("Idatzi Album berriaren AlbumId: ");
            AlbumId = in.nextInt();
            System.out.print("Idatzi Album berriaren Title: ");
            Title = in.next();
            System.out.print("Idatzi Album berriaren ArtistId: ");
            ArtistId = in.nextInt();
            datuaGordeAlbum(new Album(AlbumId, Title, ArtistId));
        } catch (Exception ex) {
            System.out.println("Daturen bat gaizki sartu duzu!");
        }
    }

    public static void albumUpdateKasua() {
        int AlbumId, ArtistId;
        String Title;
        Scanner in = new Scanner(System.in);
        try {
            System.out.print("Idatzi aldatu nahi duzun Album-aren AlbumId: ");
            AlbumId = in.nextInt();
            System.out.print("Idatzi Album-aren Title berria: ");
            Title = in.next();
            System.out.print("Idatzi Album-aren ArtistId berria: ");
            ArtistId = in.nextInt();
            datuaAldatuAlbum(AlbumId, Title, ArtistId);
        } catch (Exception ex) {
            System.out.println("Daturen bat gaizki sartu duzu!");
        }
    }

    public static void albumDeleteKasua() {
        int i;
        Scanner in = new Scanner(System.in);
        try {
            System.out.print("Idatzi ezabatu nahi duzun Album-aren AlbumId: ");
            i = in.nextInt();
            datuaEzabatuAlbum(i);
        } catch (Exception ex) {
            System.out.println("Datua gaizki sartu duzu!");
        }
    }

    public static void datuaGordeTrack(Track trk) {

        Session saioa = sf.openSession();
        saioa.beginTransaction();
        saioa.save(trk);
        saioa.getTransaction().commit();
        saioa.close();
        System.out.println("Track-a ondo gorde da!");
    }

    public static void datuakIkusiTrack() {

        Session saioa = sf.openSession();
        saioa.beginTransaction();
        List result = saioa.createQuery("from Track").list(); // HQL deitzen dan lengoaia idatziko dugu Querya
        for (Track trk : (List<Track>) result) {
            System.out.println(trk);
        }
        saioa.getTransaction().commit();
        saioa.close();
    }

    public static void datuaEzabatuTrack(int TrackId) {
        Session saioa = null;
        Track ik = null;
        Transaction tx = null;
        try {
            saioa = sf.openSession();
            tx = saioa.beginTransaction();
            ik = (Track) saioa.load(Track.class, TrackId);
            saioa.delete(ik);
            tx.commit();
        } catch (ObjectNotFoundException onfe) {
            System.out.println("Track hori ez dago");
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            saioa.close();
        }
    }

    public static void datuaAldatuTrack(int TrackId, String Name, int AlbumId, int MediaTypeId, int GenreId, String Composer, int Milliseconds, int Bytes, float UnitPrice) {
        Session saoia = sf.openSession();
        saoia.beginTransaction();

        Track a = saoia.find(Track.class, TrackId);
        a.setName(Name);
        a.setAlbumId(AlbumId);
        a.setMediaTypeId(MediaTypeId);
        a.setGenreId(GenreId);
        a.setComposer(Composer);
        a.setMilliseconds(Milliseconds);
        a.setBytes(Bytes);
        a.setUnitPrice(UnitPrice);
        saoia.getTransaction().commit();

        System.out.println("Track-a ondo eguneratuta!");
    }

    public static void datuaGordeAlbum(Album alb) {

        Session saioa = sf.openSession();
        saioa.beginTransaction();
        saioa.save(alb);
        saioa.getTransaction().commit();
        saioa.close();
        System.out.println("Album-a ondo gorde da!");
    }

    public static void datuakIkusiAlbum() {
        try {
            Session saioa = sf.openSession();
            saioa.beginTransaction();
            List result = saioa.createQuery("from Album").list(); // HQL deitzen dan lengoaia idatziko dugu Querya
            for (Album alb : (List<Album>) result) {
                System.out.println(alb);
            }
            saioa.getTransaction().commit();
            saioa.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void datuaEzabatuAlbum(int AlbumId) {
        Session saioa = null;
        Album ik = null;
        Transaction tx = null;
        try {
            saioa = sf.openSession();
            tx = saioa.beginTransaction();
            ik = (Album) saioa.load(Album.class, AlbumId);
            saioa.delete(ik);
            tx.commit();
        } catch (ObjectNotFoundException onfe) {
            System.out.println("Artista hori ez dago");
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            saioa.close();
        }
    }

    public static void datuaAldatuAlbum(int AlbumId, String Title, int ArtistId) {
        Session saoia = sf.openSession();
        saoia.beginTransaction();

        Album a = saoia.find(Album.class, AlbumId);
        a.setTitle(Title);
        a.setArtistId(ArtistId);
        saoia.getTransaction().commit();

        System.out.println("Albuma ondo eguneratuta!");
    }

    public static void datuakIkusiTrackAlbum() {
        ResultSet rs = null;

        try (
                 Connection conn = konektatu();  Statement st = conn.createStatement()) {
            rs = st.executeQuery("SELECT * FROM Track LEFT JOIN Album ON Track.AlbumId = Album.AlbumId");

            while (rs.next()) {
                int TrackId = rs.getInt("TrackId");
                String Name = rs.getString("Name");
                int AlbumId = rs.getInt("AlbumId");
                String Title = rs.getString("Title");
                int ArtistId = rs.getInt("ArtistId");
                int MediaTypeId = rs.getInt("MediaTypeId");
                int GenreId = rs.getInt("GenreId");
                String Composer = rs.getString("Composer");
                int Milliseconds = rs.getInt("Milliseconds");
                int Bytes = rs.getInt("Bytes");
                float UnitPrice = rs.getFloat("UnitPrice");
                System.out.println("TrackId = " + TrackId + ", Name = " + Name +
                        ", AlbumId = " + AlbumId + ", Title = " + Title + ", ArtistId = " + ArtistId +
                        ", MediaTypeId = " + MediaTypeId + ", GenreId = " + GenreId + ", Composer = " + Composer +
                        ", Milliseconds = " + Milliseconds + ", Bytes = " + Bytes + ", UnitPrice = " + UnitPrice);
            }
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }

    }

    public static Connection konektatu() {

        String url = "jdbc:mariadb://localhost/chinook";
        String user = "root";
        String pass = "root";
        Connection conn = null;
        System.out.println("Konektatu zara!");
        try {
            conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Konektatu zara.");
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + " - " + e.getMessage());
        }
        return conn;
    }
}
