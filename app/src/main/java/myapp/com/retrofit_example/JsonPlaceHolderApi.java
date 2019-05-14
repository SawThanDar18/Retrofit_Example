package myapp.com.retrofit_example;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * Created by User on 5/14/2019.
 */

public interface JsonPlaceHolderApi {

    //GET = select query
    @GET("https://jsonplaceholder.typicode.com/posts")  //can also write like @GET("posts")
   // Call<List<Post>> getPosts(); //all datas
    Call<List<Post>> getPosts(@Query("userId") Integer[] userId,  //userId = " "/ userId = []{2,3,5}
                              @Query("_sort") String sort,  //sort id
                              @Query("_order") String order); //order DESC  //only for selected userId

    @GET("posts")
    Call<List<Post>> getPosts(@QueryMap Map<String, String> parameters);  //@QueryMap is multiple query string

    /*@GET("https://jsonplaceholder.typicode.com/posts/2/comments")  //can also write like @GET("posts/2/comments")
    Call<List<Comment>> getComments(); //all datas*/

    //only  for selected postId
    @GET("posts/{postId}/comments")
    Call<List<Comment>> getComments(@Query("postId") int postId);

    @GET
    Call<List<Comment>> getComments(@Url String url);

    //POST = insert query
    @POST("posts")
    Call<Post> createPost(@Body Post post);

    @FormUrlEncoded
    @POST("posts")
    Call<Post> createPost(@Field("userId") int userId,
                          @Field("title") String title,
                          @Field("body") String text);

    @FormUrlEncoded
    @POST("posts")
    Call<Post> createPost(@FieldMap Map<String, String> field);

    //PUT, PATCH = update query
    @PUT("posts/{id}")
    Call<Post> putPost(@Path("id") int id, @Body Post post);

    @PATCH("posts/{id}")
    Call<Post> patchPost(@Path("id") int id, @Body Post post);

    @DELETE("posts/{id}")
    Call<Void> deletePost(@Path("id") int id);
}
