package com.example.georeminder;

import androidx.room.*;

import java.util.List;

/**
 * @author jentevandersanden
 * This interface represents the functions that perform query's on the
 * Reminder Room database.
 */
@Dao
public interface reminderDAO {
    /**
     * Gets all reminders from the database
     * @return
     */
    @Query("SELECT * FROM reminder")
    List<ReminderEntity> getAll();

    /**
     * Gets last reminder from the database
     * @return
     */
    @Query("SELECT * FROM reminder ORDER BY id DESC LIMIT 1")
    ReminderEntity getLast();

     /**
      * Deletes all reminders from the database
      * @return
      */
     @Query("DELETE FROM reminder")
     void deleteAll();


    @Query("SELECT ID FROM reminder WHERE ID LIKE :reminderID")
    String getID(String reminderID);

    /**
     * Gets the longitude of a certain reminder
     * @param reminderID : ID of the reminder you're looking for
     * @return : Returns the longitude of the reminder we were looking for.
     */
    @Query("SELECT longitude FROM reminder where ID LIKE :reminderID")
    Double getLongitude(String reminderID);

    /**
     * Gets the latitude of a certain reminder
     * @param reminderID : ID of the reminder you're looking for
     * @return : Returns the latitude of the reminder we were looking for.
     */
    @Query("SELECT latitude FROM reminder where ID LIKE :reminderID")
    Double getLatitude(String reminderID);

    /**
     * Gets the remindermessage of a certain reminder
     * @param reminderID : ID of the reminder you're looking for
     * @return : Returns the remindermessage of the reminder we were looking for.
     */
    @Query("SELECT message FROM reminder where ID LIKE :reminderID")
    String getMessage(String reminderID);

       /**
       * Gets the radius of a certain reminder
       * @param reminderID : ID of the reminder you're looking for
       * @return : Returns the radius of the reminder we were looking for.
       */
      @Query("SELECT radius FROM reminder where ID LIKE :reminderID")
      Float getRadius(String reminderID);

    /**
     * Inserts a new ReminderEntity into the database
     * @param reminder : reminder to be inserted
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertReminder(ReminderEntity reminder);

    /**
     * Deletes a reminder from the database
     * @param reminder : reminder to be deleted.
     */
    @Delete
    void deleteReminder (ReminderEntity reminder);
}
