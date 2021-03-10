package vizsgafelkészülés04.exam02senior.photocollection;

import java.util.ArrayList;
import java.util.List;

public class PhotoCollection {

    private List<Photo> photos = new ArrayList<>();

    public List<Photo> getPhotos() {
        return photos;
    }

    public void addPhoto(String...names) {
        for (String name : names) {
            photos.add(new Photo(name));
        }
    }

    public void starPhoto(String name, Quality quality) {
        for (Photo photo : photos) {
            if (photo.getName().equals(name)) {
                photo.setQuality(quality);
                return;
            }
        }
        throw new PhotoNotFoundException();
    }


    public int numberOfStars() {
        int count = 0;

        for (Photo photo : photos) {
            if (photo.getQuality() != null) {
                count += photo.getQuality().getValue();
            }
        }
        return count;
    }


}
