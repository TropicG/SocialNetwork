package bg.fmi.uni.sofia;

import bg.fmi.uni.sofia.post.Post;
import bg.fmi.uni.sofia.user.UserProfile;

import java.util.Collection;
import java.util.Set;
import java.util.SortedSet;

public interface SocialNetwork {
    void registerUser(UserProfile userProfile);

    Set<UserProfile> getAllUsers();

    Post post(UserProfile userProfile, String content);

    Collection<Post> getPosts();

    Set<UserProfile> getReachedUsers(Post post);

    Set<UserProfile> getMutualFriends(UserProfile userProfile1, UserProfile userProfile2);

    SortedSet<UserProfile> getAllProfilesSortedByFriendsCount();
}
