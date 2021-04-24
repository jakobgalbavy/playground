package net.bytesoup.playground.misc.lrucache;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

public class LruCache<KEY, VALUE> {

  private final Map<KEY, VALUE> cache = new HashMap<>();
  private final Deque<KEY> position = new LinkedList<>();
  private final int size;
  private final Function<KEY, VALUE> retrievingFn;

  public LruCache(int size, Function<KEY, VALUE> retrievingFn) {
    this.size = size;
    this.retrievingFn = retrievingFn;
  }

  public VALUE get(KEY key) {
    return getIfExists(key).orElseGet(() -> {
      VALUE value = retrievingFn.apply(key);
      this.cache.put(key, value);
      this.position.addFirst(key);

      while (this.cache.size() > this.size) {
        this.cache.remove(this.position.removeLast());
      }

      return value;
    });
  }

  public Optional<VALUE> getIfExists(KEY key) {
    if (position.remove(key)) {
      position.addFirst(key);
    }
    return Optional.ofNullable(
        cache.get(key)
    );
  }
}
