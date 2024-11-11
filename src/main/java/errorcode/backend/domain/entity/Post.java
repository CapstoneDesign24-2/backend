package errorcode.backend.domain.entity;

import errorcode.backend.domain.common.BaseEntity;
import errorcode.backend.domain.enums.PostStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "post") // 실제 몽고 DB 컬렉션 이름
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Post extends BaseEntity {
    @Id
    private String id;
    private String user_id;
    private String title;
    private String content;
    private Enum<PostStatus> status;
}
