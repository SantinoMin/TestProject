package feedmysheep.feedmysheepapi.common.global.utils.validation;

import feedmysheep.feedmysheepapi.common.global.utils.validation.ValidationGroup.LengthCheckGroup;
import feedmysheep.feedmysheepapi.common.global.utils.validation.ValidationGroup.NotEmptyGroup;
import feedmysheep.feedmysheepapi.common.global.utils.validation.ValidationGroup.PatternCheckGroup;
import jakarta.validation.GroupSequence;
import jakarta.validation.groups.Default;

@GroupSequence({Default.class, NotEmptyGroup.class, LengthCheckGroup.class, PatternCheckGroup.class})
public interface ValidationSequence {

}
