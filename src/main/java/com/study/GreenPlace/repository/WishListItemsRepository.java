package com.study.GreenPlace.repository;

import com.study.GreenPlace.entity.Ratings;
import com.study.GreenPlace.entity.WishListItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishListItemsRepository  extends JpaRepository<WishListItems, Short> {


}