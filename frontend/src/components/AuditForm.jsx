import { useState } from "react";
import api from "../api/api";
import AuditCard from "./AuditCard";
import LoadingSpinner from "./LoadingSpinner";
import ErrorAlert from "./ErrorAlert";

function AuditForm() {
  const [url, setUrl] = useState("");
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);
  const [result, setResult] = useState(null);

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (!url.trim()) {
      setError({
        code: "INVALID_INPUT",
        message: "Please enter a website URL.",
      });

      setResult(null);
      return;
    }

    setLoading(true);
    setError(null);
    setResult(null);

    try {
      const response = await api.post("/audit", {
        url,
      });

      setResult(response.data);
    } catch (err) {
      if (err.response?.data?.error) {
        setError(err.response.data.error);
      } else {
        setError({
          code: "NETWORK_ERROR",
          message: "Unable to connect to the server. Please try again.",
        });
      }
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="bg-white rounded-2xl shadow-lg p-8 mt-8">
      <form onSubmit={handleSubmit} className="flex flex-col md:flex-row gap-4">
        <input
          type="url"
          value={url}
          onChange={(e) => setUrl(e.target.value)}
          placeholder="Enter website URL (e.g. https://example.com)"
          autoFocus
          className="
            flex-1
            px-4
            py-3
            border
            border-slate-300
            rounded-xl
            outline-none
            focus:outline-none
            focus:ring-4
            focus:ring-blue-200
            focus:border-blue-500
            transition-all
          "
        />

        <button
          type="submit"
          disabled={loading}
          className="
            bg-blue-600
            hover:bg-blue-700
            disabled:bg-slate-400
            disabled:cursor-not-allowed
            text-white
            font-semibold
            px-8
            py-3
            rounded-xl
            transition-all
            duration-200
          "
        >
          {loading ? "Auditing..." : "Audit Website"}
        </button>
      </form>

      {loading && <LoadingSpinner />}

      {error && <ErrorAlert error={error} />}

      {result?.success && <AuditCard report={result} />}
    </div>
  );
}

export default AuditForm;
