package bg.fmi.uni.sofia.user;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class DefaultUserProfile implements UserProfile {

    private String username;
    private Set<Interest> interests;
    private Set<UserProfile> friends;

    public DefaultUserProfile(String username) {
        this.username = username;
        interests = new HashSet<>(Interest.TOTAL_NUMBER_INTERESTS);
        friends = new HashSet<>();
    }

    @Override
    public boolean addInterest(Interest interest) {
        if(interests.contains(interest)) {
            System.out.println("The interest is already added");
            return false;
        }

        interests.add(interest);
        return true;
    }

    @Override
    public boolean removeInterest(Interest interest) {
        if(!interests.contains(interest)) {
            System.out.println("No found interest");
            return false;
        }

        interests.remove(interest);
        return true;
    }

    @Override
    public boolean addFriend(UserProfile userProfile) {

        if(!friends.contains(userProfile)) {
            System.out.println("The user is already added");
            return false;
        }

        return friends.contains(userProfile);
    }

    @Override
    public boolean unfriend(UserProfile userProfile) {
        if(!friends.contains(userProfile)) {
            System.out.println("The user is not there");
            return false;
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
