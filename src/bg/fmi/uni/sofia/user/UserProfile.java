package bg.fmi.uni.sofia.user;

import bg.fmi.uni.sofia.exceptions.InterestNotThereException;
import bg.fmi.uni.sofia.exceptions.InterestAlreadyAddedException;
import bg.fmi.uni.sofia.exceptions.UserAlreadyAddedException;
import bg.fmi.uni.sofia.exceptions.UserNotThereException;

import java.util.Collection;

public interface UserProfile {

    boolean addInterest(Interest interest) throws InterestAlreadyAddedException;
    boolean removeInterest(Interest interest) throws InterestNotThereException;

    boolean addFriend(UserProfile userProfile) throws UserAlreadyAddedException;
    boolean unfriend(UserProfile userProfile) throws UserNotThereException;

    boolean isFriend(UserProfile userProfile);

    String getUsername();

    //should return unmodified values
    Collection<Interest> getInterest();

    //should return unmodified value
    Collection<UserProfile> getFriends();
}
