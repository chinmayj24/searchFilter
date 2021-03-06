package com.example.pglocator;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class tiffinfragment extends Fragment {

    RecyclerView recyclerview ;
    RecyclerAdapter recycleradapter;
    List<Tiffin_Information> tiffinservices;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tiffin, container, false);
        setHasOptionsMenu(true); // Add this!
        //return inflater.inflate(R.layout., container, false);
        tiffinservices = new ArrayList<>();
        recyclerview = view.findViewById(R.id.recyclerView);
        recycleradapter = new RecyclerAdapter(getContext(), tiffinservices);
        recyclerview.setAdapter(recycleradapter);


        DividerItemDecoration divideritemdecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        recyclerview.addItemDecoration(divideritemdecoration);

        tiffinservices.add(new Tiffin_Information(R.drawable.tiffinimage, "oberoi catering services", "9029512341",
                "andheri", "b1,703,anand krupa tower, hajuri road,thane.", "veg along with egg diishes",
                "we provide an ample variety of food types and dishes which will change your taste buds",
                "100-25k", "we dont work on sundays:)"));
        tiffinservices.add(new Tiffin_Information(R.drawable.tiffinimage, "manish catering services", "9029512341",
                "andheri", "b1,703,anand krupa tower, hajuri road,thane.", "veg along with egg diishes",
                "we provide an ample variety of food types and dishes which will change your taste buds",
                "100-25k", "we dont work on sundays:)"));
        tiffinservices.add(new Tiffin_Information(R.drawable.tiffinimage, "raju catering services", "9029512341",
                "andheri", "b1,703,anand krupa tower, hajuri road,thane.", "veg along with egg diishes",
                "we provide an ample variety of food types and dishes which will change your taste buds",
                "100-25k", "we dont work on sundays:)"));
        tiffinservices.add(new Tiffin_Information(R.drawable.tiffinimage, "katrina catering services", "9029512341",
                "andheri", "b1,703,anand krupa tower, hajuri road,thane.", "veg along with egg diishes",
                "we provide an ample variety of food types and dishes which will change your taste buds",
                "100-25k", "we dont work on sundays:)"));
        tiffinservices.add(new Tiffin_Information(R.drawable.tiffinimage, "zahir catering services", "9029512341",
                "andheri", "b1,703,anand krupa tower, hajuri road,thane.", "veg along with egg diishes",
                "we provide an ample variety of food types and dishes which will change your taste buds",
                "100-25k", "we dont work on sundays:)"));
        tiffinservices.add(new Tiffin_Information(R.drawable.tiffinimage, "taimur catering services", "9029512341",
                "andheri", "b1,703,anand krupa tower, hajuri road,thane.", "veg along with egg diishes",
                "we provide an ample variety of food types and dishes which will change your taste buds",
                "100-25k", "we dont work on sundays:)"));
        tiffinservices.add(new Tiffin_Information(R.drawable.tiffinimage, "rajnikanth catering services", "9029512341",
                "andheri", "b1,703,anand krupa tower, hajuri road,thane.", "veg along with egg diishes",
                "we provide an ample variety of food types and dishes which will change your taste buds",
                "100-25k", "we dont work on sundays:)"));
        tiffinservices.add(new Tiffin_Information(R.drawable.tiffinimage, "kanatbai catering services", "9029512341",
                "andheri", "b1,703,anand krupa tower, hajuri road,thane.", "veg along with egg diishes",
                "we provide an ample variety of food types and dishes which will change your taste buds",
                "100-25k", "we dont work on sundays:)"));
        tiffinservices.add(new Tiffin_Information(R.drawable.tiffinimage, "yuvraj catering services", "9029512341",
                "andheri", "b1,703,anand krupa tower, hajuri road,thane.", "veg along with egg diishes",
                "we provide an ample variety of food types and dishes which will change your taste buds",
                "100-25k", "we dont work on sundays:)"));

        return view;
    }

   /* @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.filter, menu);

        MenuItem searchitem = menu.findItem(R.id.searchfilter);
        SearchView searchview = (SearchView) searchitem.getActionView();

        searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                recycleradapter.getFilter().filter(s);
                return false;
            }
        });
        return;
    }*/
   @Override
   public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
       super.onCreateOptionsMenu(menu, inflater);
       menu.clear();

       inflater.inflate(R.menu.filter, menu);
       MenuItem item = menu.findItem(R.id.searchfilter);
       item.setShowAsAction(MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW | MenuItem.SHOW_AS_ACTION_IF_ROOM);

       SearchView searchView = (SearchView) item.getActionView();
       searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

           @Override
           public boolean onQueryTextSubmit(String query) {
               recycleradapter.getFilter().filter(query);
               return false;
           }

           @Override
           public boolean onQueryTextChange(String newText) {
               // Here is where we are going to implement the filter logic
               recycleradapter.getFilter().filter(newText);
               return true;
           }
       });
   }

}
