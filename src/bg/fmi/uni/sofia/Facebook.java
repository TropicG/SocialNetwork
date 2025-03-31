package bg.fmi.uni.sofia;

import bg.fmi.uni.sofia.post.Post;
import bg.fmi.uni.sofia.post.SocialFeedPost;
import bg.fmi.uni.sofia.user.FriendsCountComparator;
import bg.fmi.uni.sofia.user.Interest;
import bg.fmi.uni.sofia.user.UserProfile;

import java.util.*;

public class Facebook implements SocialNetwork{

    private Set<UserProfile> userProfiles;
    private Collection<Post> posts;

    public Facebook() {
        userProfiles = new HashSet<>();
        posts = new ArrayList<>();
    }

    @Override
    public void registerUser(UserProfile userProfile) {

        if(userProfiles.contains(userProfile)) {
            System.out.println("The User is already added to the SocialNetwork");
            return;
        }

        userProfiles.add(userProfile);
    }

    @Override
    public Set<UserProfile> getAllUsers() {
        return userProfiles;
    }

    @Override
    public Post post(UserProfile userProfile, String content) {

        if(!userProfiles.contains(userProfile)) {
            System.out.println("This user is not defined");
            return null;
        }

        Post newPost = new SocialFeedPost(userProfile, content);

        if(posts.contains(newPost)) {
            System.out.println("This post is already defined");
            return null;
        }

        posts.add(newPost);
        return newPost;
    }

    @Override
    public Collection<Post> getPosts() {
        return Collections.unmodifiableCollection(posts);
    }

    @Override
    public Set<UserProfile> getReachedUsers(Post post) {

        Set<UserProfile> reachedUsers = new HashSet<>();

        for(UserProfile user : userProfiles) {

            //adds all the users who has the author as a friend
            if(user.isFriend(post.getAuthor())) {
                reachedUsers.add(user);
            }

            //adds all the users who have at least one common interest as the author
            Set<Interest> userInterest = new HashSet<>(user.getInterest());
            Set<Interest> authorInterest = new HashSet<>(post.getAuthor().getInterest());

            authorInterest.retainAll(userInterest);

            if(!authorInterest.isEmpty()) {
                reachedUsers.add(user);
            }

        }

        return reachedUsers;
    }

    @Override
    public Set<UserProfile> getMutualFriends(UserProfile userProfile1, UserProfile userProfile2) {
        Set<UserProfile> mutualFriends = new HashSet<>(userProfile1.getFriends());
        mutualFriends.retainAll(userProfile2.getFriends());

        return mutualFriends;
    }

    @Override
    public SortedSet<UserProfile> getAllProfilesSortedByFriendsCount() {

        SortedSet<UserProfile> sortedProfiles = new TreeSet<>(new FriendsCountComparator());
        sortedProfiles.addAll(userProfiles);

        return sortedProfiles;
    }
}
