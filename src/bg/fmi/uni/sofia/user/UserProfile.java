package bg.fmi.uni.sofia.user;

import java.util.Collection;

public interface UserProfile {

    boolean addInterest(Interest interest);
    boolean removeInterest(Interest interest);

    boolean addFriend(UserProfile userProfile);
    boolean unfriend(UserProfile userProfile);

    boolean isFriend(UserProfile userProfile);

    String getUsername();

    //should return unmodified values
    Collection<Interest> getInterest();

    //should return unmodified value
    Collection<UserProfile> getFriends();
}
