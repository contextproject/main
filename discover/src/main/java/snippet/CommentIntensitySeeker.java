package snippet;

import java.util.Set;
import java.util.TreeSet;

public class CommentIntensitySeeker {

  protected int getStartTime(Set<Comment> coms, int duration) {
    if (coms.isEmpty()) {
      return 0;
    }
    int start = 0;
    int maxcount = 0;
    Set<Integer> passed = new TreeSet<Integer>();
    for (Comment c : coms) {
      int count = 0;
      if (!passed.contains(c.getTime())) {
        for (Comment c2 : coms) {
          if (c2.getTime() >= c.getTime() && c2.getTime() <= (c.getTime() + duration)) {
            count++;
          }
        }
        if (count > maxcount) {
          maxcount = count;
          start = c.getTime();
        }
        passed.add(c.getTime());
      }
    }
    return start;
  }

  public TimedSnippet seek(Set<Comment> coms) {

    return new TimedSnippet(getStartTime(coms, TimedSnippet.getDefaultDuration()));

  }

  public TimedSnippet seekDuration(Set<Comment> coms, int duration) {
    return new TimedSnippet(getStartTime(coms, duration), duration);
  }

}
