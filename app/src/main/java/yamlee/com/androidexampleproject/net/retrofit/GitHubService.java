package yamlee.com.androidexampleproject.net.retrofit;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import yamlee.com.androidexampleproject.net.retrofit.entity.Repo;

/**
 * Created by yamlee on 15/10/8.
 */
public interface GitHubService {
    @GET("/users/{user}/repos")
    Call<List<Repo>> listRepos(@Path("user") String user);

}
