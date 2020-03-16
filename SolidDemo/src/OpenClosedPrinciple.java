//Open-Closed Principle-->software entities (classes, modules, functions, etc.)
// should be open for extension, but closed for modification”
//violates Open-closed since if new album comes we need to modify the class
class MusicApp {
    void playAlbum(String Album) {
        if (Album.equals("abc"))
            play(abc);
        else if (Album.equals("def"))
            play(abc);
    }
}

//resolved

class MusicApp{
    void playAlbum(){

    }
}


class abc extends MusicApp{
    void playAlbum(){
        play(abc);
    }
}

class def extends MusicApp{
    void playAlbum(){
        play(def);
    }
}
