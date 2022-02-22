import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class PhotoSorter {

    private class Photo implements Comparable<Photo> {
        Integer id;
        String city;
        String photoName;
        Date timeTaken;

        public Photo(Integer id, String city, String photoName, Date timeTaken) {
            this.id = id;
            this.city = city;
            this.photoName = photoName;
            this.timeTaken = timeTaken;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((city == null) ? 0 : city.hashCode());
            result = prime * result + ((id == null) ? 0 : id.hashCode());
            result = prime * result + ((photoName == null) ? 0 : photoName.hashCode());
            result = prime * result + ((timeTaken == null) ? 0 : timeTaken.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Photo other = (Photo) obj;
            if (city == null) {
                if (other.city != null)
                    return false;
            } else if (!city.equals(other.city))
                return false;
            if (id == null) {
                if (other.id != null)
                    return false;
            } else if (!id.equals(other.id))
                return false;
            if (photoName == null) {
                if (other.photoName != null)
                    return false;
            } else if (!photoName.equals(other.photoName))
                return false;
            if (timeTaken == null) {
                if (other.timeTaken != null)
                    return false;
            } else if (!timeTaken.equals(other.timeTaken))
                return false;
            return true;
        }

        @Override
        public int compareTo(Photo obj) {
            if (this.timeTaken.after(obj.timeTaken)) {
                return 1;
            } else if (this.timeTaken.before(obj.timeTaken)) {
                return -1;
            }
            return 0;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getPhotoName() {
            return photoName;
        }

        public void setPhotoName(String photoName) {
            this.photoName = photoName;
        }

        public Date getTimeTaken() {
            return timeTaken;
        }

        public void setTimeTaken(Date timeTaken) {
            this.timeTaken = timeTaken;
        }

    }

    public static void main(String[] args) throws ParseException {
        PhotoSorter sorter = new PhotoSorter();
        Photo photo1 = sorter.new Photo(1, "Warsaw", "photo.jpg",
                new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").parse("2013-09-05 14:08:15"));
        Photo photo2 = sorter.new Photo(2, "Warsaw", "photo.jpg",
                new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").parse("2013-09-05 14:08:15"));
        Photo photo3 = sorter.new Photo(3, "Warsaw", "photo.jpg",
                new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").parse("2013-09-05 14:08:15"));
        Photo photo4 = sorter.new Photo(4, "Warsaw", "photo.jpg",
                new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").parse("2013-09-05 14:08:15"));
        Photo photo5 = sorter.new Photo(5, "Jaipur", "photo.jpg",
                new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").parse("2013-09-05 14:08:15"));
        Photo photo6 = sorter.new Photo(6, "Warsaw", "photo.jpg",
                new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").parse("2013-09-05 14:08:15"));
        Photo photo7 = sorter.new Photo(7, "Warsaw", "photo.jpg",
                new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").parse("2013-09-05 14:08:15"));
        Photo photo8 = sorter.new Photo(8, "Warsaw", "photo.jpg",
                new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").parse("2013-09-05 14:08:15"));
        Photo photo9 = sorter.new Photo(9, "Warsaw", "photo.jpg",
                new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").parse("2013-09-05 14:08:15"));
        Photo photo10 = sorter.new Photo(10, "Warsaw", "photo.jpg",
                new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").parse("2013-09-05 14:08:15"));
        Photo photo11 = sorter.new Photo(11, "Jaipur", "photo.jpg",
                new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").parse("2013-09-05 14:08:15"));
        Photo photo12 = sorter.new Photo(12, "Jaipur", "photo.jpg",
                new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").parse("2013-09-05 14:08:15"));

        List<Photo> photos = Arrays.asList(photo1, photo2, photo3, photo4, photo5, photo6, photo7, photo8, photo9,
                photo10, photo11, photo12);
        System.out.println(renamePhotos(photos));
    }

    public String solution(String S) {
        String[] photosAsString = S.split(System.lineSeparator());

        List<Photo> photosObj = new ArrayList<>();
        for (int i = 0; i < photosAsString.length; i++) {
            String[] photoIdentifiers = photosAsString[i].split(",");
            Photo photo = null;
            try {
                photo = new Photo(i, photoIdentifiers[1], photoIdentifiers[0],
                        new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").parse(photoIdentifiers[2]));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            photosObj.add(photo);
        }

        return renamePhotos(photosObj);
    }

    private static String renamePhotos(List<Photo> photos) {
        Map<String, List<Photo>> record = new HashMap<>();
        for (Photo aPhoto : photos) {
            String city = aPhoto.getCity();

            if (record.containsKey(city)) {
                List<Photo> existingPhotos = record.get(city);
                List<Photo> newPhotos = new ArrayList<>(existingPhotos);
                newPhotos.add(aPhoto);
                record.put(city, newPhotos);
            } else {
                record.put(city, Arrays.asList(aPhoto));
            }
        }

        Map<String, Integer> countByCity = new HashMap<>();
        for (Entry<String, List<Photo>> entrySetObj : record.entrySet()) {
            String country = entrySetObj.getKey();
            Integer count = entrySetObj.getValue().size();

            countByCity.put(country, count);
            Collections.sort(entrySetObj.getValue());
        }

        for (Map.Entry<String, List<Photo>> entryObj : record.entrySet()) {
            String city = entryObj.getKey();
            Integer num = countByCity.get(city);

            Integer digitCount = 0;
            for (; num != 0; num /= 10, ++digitCount)
                ;
            System.out.println(digitCount);
            for (Photo aPhoto : entryObj.getValue()) {
                String newPhotoName = city + String.format("%0" + digitCount + "d", ++num);
                aPhoto.setPhotoName(newPhotoName);
            }
        }

        List<Photo> allPhotos = new ArrayList<>();
        for (Map.Entry<String, List<Photo>> entryObj : record.entrySet()) {
            allPhotos.addAll(entryObj.getValue());
        }

        Collections.sort(allPhotos, new Comparator<Photo>() {
            public int compare(Photo o1, Photo o2) {
                return o1.getId().compareTo(o2.getId());
            }
        });

        String allRenamedPhotoNames = "";
        for (Photo aPhoto : allPhotos) {
            allRenamedPhotoNames = aPhoto.getPhotoName() + "\n";
        }
        return allRenamedPhotoNames;
    }
}
