package tianki.recyclerviewforhorizontal;

/**
 * Created by Tiank on 9/7/2017.
 */

public class Fruit {
    private  String _name;
    private int _imageId;

    public Fruit(String name,int imageId){
        this._name=name;
        this._imageId=imageId;
    }

    public  String getName(){
        return  _name;
    }

    public  int get_ImageId(){
        return _imageId;
    }
}
