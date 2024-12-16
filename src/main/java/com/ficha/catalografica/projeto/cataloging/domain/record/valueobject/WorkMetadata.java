package com.ficha.catalografica.projeto.cataloging.domain.record.valueobject;

import io.micrometer.common.util.StringUtils;

public class WorkMetadata {

  private final String title;

  private final String format;

  private final String subtitle;

  private final int pages;

  private final boolean hasIllustration;

  private final boolean hasColor;

  public WorkMetadata(String title, String format, String subtitle, int pages, boolean hasIllustration,
      boolean hasColor) {
    if (StringUtils.isBlank(title))
      throw new IllegalArgumentException("title cannot be null or empty");
    if (StringUtils.isBlank(format))
      throw new IllegalArgumentException("format cannot be null or empty");
    if (StringUtils.isBlank(subtitle))
      throw new IllegalArgumentException("subtitle cannot be null or empty");
    if (pages <= 0)
      throw new IllegalArgumentException("pages have to be greater than zero");

    this.title = title;
    this.format = format;
    this.subtitle = subtitle;
    this.pages = pages;
    this.hasIllustration = hasIllustration;
    this.hasColor = hasColor;
  }

  public String getTitle() {
    return title;
  }

  public String getFormat() {
    return format;
  }

  public String getSubtitle() {
    return subtitle;
  }

  public int getPages() {
    return pages;
  }

  public boolean hasIllustration() {
    return hasIllustration;
  }

  public boolean hasColor() {
    return hasColor;
  }

}
