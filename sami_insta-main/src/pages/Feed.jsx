import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import Post from "../components/Post";
import api from "../services/api";

export default function Feed() {
    const [posts, setPosts] = useState([]);
    const navigate = useNavigate();

    const userId = localStorage.getItem("userId");

    const fetchFeed = async () => {
        if (!userId) return; 
        try {
            const res = await api.get(`/posts/feed?userId=${userId}`);
            setPosts(res.data);
        } catch (err) {
            console.error("Error fetching feed:", err);
        }
    };

    useEffect(() => {
        if (!userId) {
            navigate("/login");
            return;
        } else{
            fetchFeed();
        }
    }, [userId, navigate]);

    return (
        <div>
            <h2>Feed</h2>
            {posts.length === 0 ? (
                <p>No posts to show.</p>
            ) : (
                posts.map((p) => <Post key={p.id} post={p} />)
            )}
        </div>
    );
}
