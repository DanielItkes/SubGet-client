package com.example.subget.app_data.local_db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.subget.app_data.models.Listing


@Dao
interface DatabaseDAO {

    // Inserts a list of Listings into Room
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(listings: List<Listing>)

    // Get all Listings from Room
    @Query("SELECT * FROM listings")
    fun localGetAllListings(): LiveData<List<Listing>>

    // Get a single Listing from Room
    @Query("SELECT * from listings WHERE id = :id")
    fun localGetSingleListing(id: Int): LiveData<Listing>

    // Get all Listings which are classified as favorites from Room
    @Query("SELECT * FROM listings WHERE favorite = 0")
    fun localGetFavorites(): LiveData<List<Listing>>

    // Get all Listings from Room
    @Query("SELECT * FROM listings WHERE address LIKE :address")
    fun localGetListingsByAddress(address: String): LiveData<List<Listing>>

}