package ra.com.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {
    private static final String CLOUD_NAME = "dfvrrxxnd";
    private static final String API_KEY = "976967131576399";
    private static final String API_SECRET = "cbHHe3dHn8ZDMNqx_IDRfhn9n0Y";

    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", CLOUD_NAME,
                "api_key", API_KEY,
                "api_secret", API_SECRET
        ));
    }
}
