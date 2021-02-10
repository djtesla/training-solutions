package week15d02;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class PostFinder {

    private List<Post> posts;

    public PostFinder(List<Post> posts) {
        this.posts = posts;
    }


    public List<Post> findPostsFor(String user) {
        List<Post> selectedPosts = new ArrayList<>();
        for (Post post : posts) {
            if (isPostAcceptable(post, user)) {
                selectedPosts.add(post);
            }
        }
        return selectedPosts;
    }



    private boolean isPostAcceptable(Post post, String user) {
        if (isEmpty(post.getTitle()) || isEmpty(post.getContent())) {
            return false;
        }
        if (post.getPublishedAt().isAfter(LocalDate.now())) {
            return false;
        }
        return post.getOwner().equals(user);
    }



    private boolean isEmpty(String text) {
        return (text == null || "".equals(text));
    }


    public static void main(String[] args) {
        PostFinder pf = new PostFinder(new ArrayList<>(Arrays.asList(
                new Post("Kőrösi utca 5.", LocalDate.of(2010, 1, 10), "xy", "Egyéb"),
                new Post("Bátori utca 10.", LocalDate.of(2021, 10, 10), "xy", "Budapest Bank"),
                new Post("Posta köz 10.", LocalDate.of(1970, 3, 10), "xy", "Lőrinc"),
                new Post("Mihályi út 1.", LocalDate.of(2015, 5, 10), "", null),
                new Post("Mihályi út 1.", LocalDate.of(2000, 11, 10), "xy", "Egyéb"))));

        List<Post> selectedPosts = pf.findPostsFor("Egyéb");
        System.out.println(selectedPosts.toString());
    }
}



 /* Implementáljunk a PostFinder osztályban egy public List<Post> findPostsFor(String user) metódust az alábbi módon:
    - Csak olyan Post-ot adjunk vissza, amelynek az owner-e megegyezik a megadott user-rel
- A Post publishedAt dátuma korábbi kell, hogy legyen, mint a LocalDate.now()
    - A content és a title nem lehet üres
    Tároljunk egy List<Post> objektumot a PostFinder osztályban, melyet konstruktor paraméterként kap meg és ezt használjuk! (edited)*/

