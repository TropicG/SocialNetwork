package bg.fmi.uni.sofia.user;

import bg.fmi.uni.sofia.exceptions.InterestNotThereException;
import bg.fmi.uni.sofia.exceptions.InterestAlreadyAddedException;
import bg.fmi.uni.sofia.exceptions.UserAlreadyAddedException;
import bg.fmi.uni.sofia.exceptions.UserNotThereException;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class DefaultUserProfile implements UserProfile {

    private String username;
    private Set<Interest> interests;
    private Set<UserProfile> friends;

    public DefaultUserProfile(String username) {
        this.username = username.isEmpty() ? "Username" : username;
        interests = new HashSet<>(Interest.TOTAL_NUMBER_INTERESTS);
        friends = new HashSet<>();
    }

    @Override
    public boolean addInterest(Interest interest) throws InterestAlreadyAddedException {

        if(interest == null) {
            throw new NullPointerException("Null passed as interest");
        }

        if(interests.contains(interest)) {
            throw new InterestAlreadyAddedException("The Interest is already added");
        }

        interests.add(interest);
        return true;
    }

    @Override
    public boolean removeInterest(Interest interest) throws InterestNotThereException {

        if(interest == null) {
            throw new NullPointerException("Null passed as interest");
        }

        if(!interests.contains(interest)) {
            throw new InterestNotThereException("The interest is already added");
        }

        interests.remove(interest);
        return true;
    }

    @Override
    public boolean addFriend(UserProfile userProfile) throws UserAlreadyAddedException{

        if(userProfile == null) {
            throw new NullPointerException("Null passed as userProfile");
        }

        if(friends.contains(userProfile)) {
            throw new UserAlreadyAddedException("The user is already added");
        }

        return friends.add(userProfile);
    }

    @Override
    public boolean unfriend(UserProfile userProfile) throws UserNotThereException{

        if(userProfile == null) {
            throw new NullPointerException("Null passed as userProfile");
        }

        if(!friends.contains(userProfile)) {
            throw new UserNotThereException("The user is not there");
        }

        return friends.remove(userProfile);
    }

    @Override
    public boolean isFriend(UserProfile userProfile) {
        return friends.contains(userProfile);
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public Collection<Interest> getInterest() {
        return Collections.unmodifiableCollection(interests);
    }

    @Override
    public Collection<UserProfile> getFriends() {
        return Collections.unmodifiableCollection(friends);
    }

    @Override
    public String toString() {
        return username + " Interests: " + interests.toString() + " Friends: " + friends.toString();
    }

}
