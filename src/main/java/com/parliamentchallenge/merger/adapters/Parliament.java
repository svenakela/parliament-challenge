package com.parliamentchallenge.merger.adapters;

import com.parliamentchallenge.merger.speech.MergedSpeech;

public interface Parliament {

  MergedSpeech latestSpeeches(int numberOfSpeeches);

}
