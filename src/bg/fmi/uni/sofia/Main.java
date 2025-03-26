package bg.fmi.uni.sofia;

import bg.fmi.uni.sofia.user.DefaultUserProfile;
import bg.fmi.uni.sofia.user.Interest;

public class Main {


    public static void main(String[] args) {

        DefaultUserProfile userProfile = new DefaultUserProfile("TropicGamerMC");


        userProfile.addInterest(Interest.GAMES);
        userProfile.addInterest(Interest.BOOKS);

        System.out.println(userProfile.toString());


    }




}
