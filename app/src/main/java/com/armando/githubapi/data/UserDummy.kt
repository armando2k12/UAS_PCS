package com.armando.githubapi.data

object UserDummy {

    val list: ArrayList<User>
    get() {

        val list = arrayListOf<User>()


        list.add(User(
            "edmt",
            "https://avatars1.githubusercontent.com/u/1228524?v=4",
            "https://github.com/edmt",
            "https://api.github.com/users/edmt/followers",
            28,
            "https://api.github.com/users/edmt/following{/other_user}",
            53,
            "https://api.github.com/users/edmt/repos",
            29
        ))
        list.add(User(
            "edmtrv",
            "https://avatars3.githubusercontent.com/u/33452354?v=4",
            "https://api.github.com/users/edmtrv",
            "https://api.github.com/users/edmtrv/followers",
            28,
            "https://api.github.com/users/edmtrv/following{/other_user}",
            53,
            "https://api.github.com/users/edmttrv/repos",
            29
        ))
        list.add(User(
            "edmtzx",
            "https://avatars3.githubusercontent.com/u/4977102?v=4",
            "https://github.com/users/edmtzx",
            "https://api.github.com/users/edmtzx/followers",
            28,
            "https://api.github.com/users/edmtzx/following{/other_user}",
            53,
            "https://api.github.com/users/edmtzx/repos",
            29
        ))
        list.add(User(
            "BaharTaskesen",
            "https://avatars0.githubusercontent.com/u/32884710?v=4",
            "https://github.com/edmt",
            "https://api.github.com/users/edmt/followers",
            28,
            "https://api.github.com/users/BaharTaskesen/following{/other_user}",
            53,
            "https://api.github.com/users/BaharTaskesen/repos",
            29
        ))

        list.add(User(
            "EDMTunes",
            "https://avatars2.githubusercontent.com/u/43973821?v=4",
            "https://github.com/EDMTunes",
            "https://api.github.com/users/EDMTunes/followers",
            28,
            "https://api.github.com/users/EDMTunes/following{/other_user}",
            53,
            "https://api.github.com/users/EDMTunes/repos",
            29
        ))

        return list
    }
}