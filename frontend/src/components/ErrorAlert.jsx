import { FiAlertTriangle } from "react-icons/fi";

function ErrorAlert({ error }) {
  return (
    <div
      className="
        mt-6
        rounded-xl
        border
        border-red-300
        bg-red-50
        p-4
      "
    >
      <h3 className="flex items-center gap-2 font-semibold text-red-700">
        <FiAlertTriangle className="text-lg" />
        {error.code}
      </h3>

      <p className="mt-2 text-red-600">
        {error.message}
      </p>
    </div>
  );
}

export default ErrorAlert;