package com.study.GreenPlace.repository;

import com.study.GreenPlace.entity.Ratings;
import com.study.GreenPlace.entity.WishListItems;
import com.study.GreenPlace.entity.WishLists;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface WishListItemsRepository  extends JpaRepository<WishListItems, Short> {

    @Query("SELECT w FROM WishListItems w WHERE w.wishlistid.wishlistid = :id")
    public List<WishListItems> findWishlistItemByWishlistId(@Param("id")short id);

    @Query("SELECT w FROM WishListItems w WHERE w.placeid.placeid = :id")
    public List<WishListItems> findWishlistItemByPlaceId(@Param("id")short id);

    @Modifying // allow delete
    @Transactional // allow delete
    @Query("DELETE FROM WishListItems w WHERE w.placeid.placeid = :id")
    public void deleteWishlistItemByPlaceId(@Param("id")short id);
}
