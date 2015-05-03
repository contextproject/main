package snippet;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;



import org.junit.Before;
import org.junit.Test;


import java.util.HashSet;
import java.util.Set;







public class CommentIntensitySeekerTest {

  private CommentIntensitySeeker cis;
  private Comment c1;
  private Comment c3;
  private Comment c4;
  private Comment c5;
  private Comment c6;
  private Comment c7;
  private Comment c8;
  private Comment c9;

  /**
   * Setting up 2 classes to test with.
   */
  @Before
  public void makeComments() {
    cis = new CommentIntensitySeeker();
    c1 = new Comment(1, 5000);
    c3 = new Comment(3, 15000);
    c4 = new Comment(4, 16000);
    c5 = new Comment(5, 18000);
    c6 = new Comment(6, 21000);
    c7 = new Comment(7, 50000);
    c8 = new Comment(8, 41000);
    c9 = new Comment(9, 42000);

  }

  /**
   * Test the seek function with a set of zero comments.
   */
  @Test
  public void testSeekZero() {
    Set<Comment> set = new HashSet<Comment>();
    TimedSnippet ts = cis.seek(set);
    assertEquals(0, ts.getStartTime());
    assertEquals(30000, ts.getDuration());
  }

  /**
   * Test the seek function with a set of comments with the timestamp centered at one point.
   */
  @Test
  public void testSeek1() {
    Set<Comment> set = new HashSet<Comment>();
    set.add(c3);
    set.add(c4);
    set.add(c5);
    set.add(c6);
    TimedSnippet ts = cis.seek(set);
    assertEquals(15000, ts.getStartTime());
    assertEquals(30000, ts.getDuration());
  }

  /**
   * Test the seek function with a set of comments with the timestamp centered at a other point.
   */
  @Test
  public void testSeek2() {
    Set<Comment> set = new HashSet<Comment>();
    set.add(c3);

    set.add(c7);
    set.add(c8);
    set.add(c9);
    TimedSnippet ts = cis.seek(set);
    assertEquals(40000, ts.getStartTime());
    assertEquals(30000, ts.getDuration());
  }

  /**
   * Test the seek function with only 2 comments.
   */
  @Test
  public void testSeek3() {
    Set<Comment> set = new HashSet<Comment>();
    set.add(c1);

    set.add(c9);
    TimedSnippet ts = cis.seek(set);
    assertEquals(5000, ts.getStartTime());
    assertEquals(30000, ts.getDuration());
  }

  /**
   * Test the seek function with a duration.
   */
  @Test
  public void testSeekwithDuration() {
    Set<Comment> set = new HashSet<Comment>();
    set.add(c3);
    set.add(c4);
    set.add(c5);
    set.add(c6);
    TimedSnippet ts = cis.seekDuration(set, 45000);
    assertEquals(15000, ts.getStartTime());
    assertEquals(45000, ts.getDuration());
  }

  /**
   * Testing if the functions of the Comment class are used.
   */
  @Test
  public void testDependency() {
    Set<Comment> set = new HashSet<Comment>();

    Comment com = mock(Comment.class);
    set.add(com);
    TimedSnippet ts = cis.seek(set);
    assertEquals(0, ts.getStartTime());
    assertEquals(30000, ts.getDuration());
    verify(com, times(7)).getTime();
    verify(com).hashCode();
  }

}
