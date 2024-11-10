package edu.grinnell.csc207;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

import edu.grinnell.csc207.util.AssociativeArray;
import edu.grinnell.csc207.util.KeyNotFoundException;
import edu.grinnell.csc207.util.NullKeyException;

/**
 * A place for you to put your own tests (beyond the shared repo).
 *
 * @author Khanh Do
 */
public class TestsFromStudent {
  /**
   * Test use case: making a student id book.
   *
   * @throws NullKeyException
   */
  @Test
  public void khanhDoTest1() throws NullKeyException {
    AssociativeArray<String, UUID> studentIds = new AssociativeArray<>();
    UUID[] ids = new UUID[30];
    int classSize = 30;
    for (int i = 0; i < classSize; i++) {
      ids[i] = UUID.randomUUID();
      studentIds.set("Student " + i, ids[i]);
    } // for
    assertEquals(30, studentIds.size());
    for (int i = 0; i < classSize; i++) {
      try {
        assertEquals(ids[i], studentIds.get("Student " + i));
      } catch (KeyNotFoundException e) {
        fail("Failed to get student ID. Message: " + e.getMessage());
      } // try/catch
    } // for
  } // khanhDoTest1()

  /**
   * Setting and getting an object as the key should not throw.
   *
   * @throws NullKeyException
   */
  @Test
  public void khanhDoTest2() throws NullKeyException {
    AssociativeArray<Object, String> arr = new AssociativeArray<>();
    Object object = new Object();
    String value = "Object key";
    arr.set(object, value);
    try {
      assertTrue(arr.hasKey(object), "Array should have object key.");
      assertEquals(value, arr.get(object));
    } catch (KeyNotFoundException e) {
      fail("Failed to get object key. Message: " + e.getMessage());
    } // try/catch
  } // khanhDoTest2()

  /**
   * Setting, getting, and removing an empty string key should not throw.
   * 
   * @throws NullKeyException
   */
  @Test
  public void khanhDoEdge1() throws NullKeyException {
    // making the list
    AssociativeArray<String, String> arr = new AssociativeArray<>();
    String key = "";
    String value = "Empty string key";

    // setting empty string as key
    try {
      arr.set(key, value);
    } catch (NullKeyException e) {
      fail("Failed to set empty string key. Message: " + e.getMessage());
    } // try/catch

    // getting empty string key
    try {
      assertEquals(value, arr.get(key), "getting with empty string");
    } catch (KeyNotFoundException e) {
      fail("Failed to get empty string key. Message: " + e.getMessage());
    } // try/catch

    // checking if array has empty string key
    assertTrue(arr.hasKey(key), "Array should have empty string key.");

    // removing empty string key
    arr.remove(key);
    assertFalse(arr.hasKey(key), "Array should not have empty string key anymore.");
  } // khanhDoEdge1()
} // class TestsFromSam
