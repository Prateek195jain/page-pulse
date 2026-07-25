import StatCard from "./StatCard";
import {
  HiOutlineGlobeAlt,
  HiOutlineClock,
  HiOutlineDocumentText,
  HiOutlinePhoto,
} from "react-icons/hi2";

function AuditCard({ report }) {
  const data = report.data;

  const statusColor =
    data.httpStatus >= 200 && data.httpStatus < 300
      ? "text-green-600"
      : data.httpStatus >= 300 && data.httpStatus < 400
        ? "text-yellow-600"
        : "text-red-600";

  return (
    <div
      className="bg-white/80
backdrop-blur-md
rounded-2xl
shadow-xl
border
border-white/50 p-8 mt-6 border border-slate-200"
    >
      <h2 className="text-2xl font-bold text-slate-800 mb-6">Audit Report</h2>
      <div className="mb-6">
        <p className="text-sm text-slate-500">Audited URL</p>

        <a
          href={data.url}
          target="_blank"
          rel="noopener noreferrer"
          className="
            text-blue-600
            hover:text-blue-700
            hover:underline
            break-all
            font-medium
        "
        >
          {data.url}
        </a>
      </div>
      <hr className="mb-6 border-slate-200" />

      <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
        <StatCard
          icon={<HiOutlineGlobeAlt />}
          label="HTTP Status"
          value={data.httpStatus}
          valueColor={statusColor}
        />
        <StatCard
          icon={<HiOutlineClock />}
          label="Response Time"
          value={`${data.responseTimeMs} ms`}
        />

        <StatCard
          icon={<HiOutlineDocumentText />}
          label="H1 Count"
          value={data.h1Count}
        />

        <StatCard
          icon={<HiOutlinePhoto />}
          label="Images Missing Alt"
          value={data.imagesMissingAlt}
        />
      </div>

      <div className="mt-8">
        <h3 className="text-lg font-semibold text-slate-800">Page Title</h3>

        <div className="mt-2 rounded-lg bg-slate-50 border border-slate-200 p-4">
          <p className="text-slate-700 break-words">
            {data.pageTitle || "N/A"}
          </p>
        </div>
      </div>

      <div className="mt-6">
        <h3 className="text-lg font-semibold text-slate-800">
          Meta Description
        </h3>

        <div className="mt-2 rounded-lg bg-slate-50 border border-slate-200 p-4">
          <p className="mt-2 text-slate-600 break-words">
            {data.metaDescription || "No meta description found."}
          </p>
        </div>
      </div>

      <div className="mt-6">
        <h3 className="text-lg font-semibold text-slate-800">
          Approximate Word Count
        </h3>

        <div className="mt-2 rounded-lg bg-slate-50 border border-slate-200 p-4">
          <p className="mt-2 text-slate-600 font-semibold">{data.wordCount}</p>
        </div>
      </div>
    </div>
  );
}

export default AuditCard;
