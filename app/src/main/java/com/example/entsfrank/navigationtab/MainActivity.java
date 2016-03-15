package com.example.entsfrank.navigationtab;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import de.madcyph3r.materialnavigationdrawer.MaterialNavigationDrawer;
import de.madcyph3r.materialnavigationdrawer.activity.MaterialNavHeadItemActivity;
import de.madcyph3r.materialnavigationdrawer.head.MaterialHeadItem;
import de.madcyph3r.materialnavigationdrawer.menu.MaterialMenu;
import de.madcyph3r.materialnavigationdrawer.menu.item.section.MaterialItemSectionFragment;
import de.madcyph3r.materialnavigationdrawer.tools.RoundedCornersDrawable;

public class MainActivity extends MaterialNavHeadItemActivity {
    MaterialNavigationDrawer drawer = null;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
////    }

    @Override
    protected boolean finishActivityOnNewIntent() {
        return false;
    }

    @Override
    protected int getNewIntentRequestCode(Class clazz) {
        return 0;
    }
    @Override
    public void init(Bundle savedInstanceState) {

        drawer = this;

        // information text for the fragment
        Bundle bundle = new Bundle();
        bundle.putString("instruction", "This example shows the head item style.");

        Fragment fragmentInstruction = new fragment1();
        fragmentInstruction.setArguments(bundle);


        // create menu
        MaterialMenu menu = new MaterialMenu();
        menu.add(new MaterialItemSectionFragment(this, "Instruction", fragmentInstruction, "Head Item Style (One Item)"));
        menu.add(new MaterialItemSectionFragment(this, "list 1", new fragment2(), "Section 1"));
        menu.add(new MaterialItemSectionFragment(this, "list 2", new fragment3(), "Section 2"));
        menu.add(new MaterialItemSectionFragment(this, "list 3", new fragment4(), "Section 3"));

        // use bitmap and make a circle photo
        final Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.youravatar);
        final RoundedCornersDrawable drawableAppIcon = new RoundedCornersDrawable(getResources(), bitmap);
        MaterialHeadItem headItem = new MaterialHeadItem(this, "My HeadItem", "My Subtitle", drawableAppIcon, R.drawable.yourbackground, menu);
        this.addHeadItem(headItem);

        // load menu
        this.loadMenu(getCurrentHeadItem().getMenu());

        // load the first MaterialItemSectionFragment from the menu
        this.loadStartFragmentFromMenu(getCurrentHeadItem().getMenu());
    }

    @Override
    public void afterInit(Bundle savedInstanceState) {

    }
}