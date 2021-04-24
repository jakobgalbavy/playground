package net.bytesoup.playground.misc.lrucache;

import java.util.function.Function;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class LruCacheTest {

  @Rule
  public MockitoRule initRule = MockitoJUnit.rule();

  @Mock
  private Function<String, String> stringFunction;

  @Test
  public void addDuplicate_callsFnOnce() {
    Mockito.when(stringFunction.apply(Mockito.anyString())).thenReturn("a");
    LruCache<String, String> cache = new LruCache<>(1, stringFunction);
    cache.get("a");
    cache.get("a");
    Mockito.verify(stringFunction).apply("a");
  }

  @Test
  public void addSix_evictionWorks_firstNotInCache() {
    Mockito.when(stringFunction.apply(Mockito.anyString())).thenReturn("a");
    LruCache<String, String> cache = new LruCache<>(5, stringFunction);
    cache.get("a");
    cache.get("b");
    cache.get("c");
    cache.get("d");
    cache.get("e");
    cache.get("f");
    cache.get("a");
    Mockito.verify(stringFunction).apply("b");
    Mockito.verify(stringFunction).apply("c");
    Mockito.verify(stringFunction).apply("d");
    Mockito.verify(stringFunction).apply("e");
    Mockito.verify(stringFunction).apply("f");
    Mockito.verify(stringFunction, Mockito.times(2)).apply("a");
  }
}
