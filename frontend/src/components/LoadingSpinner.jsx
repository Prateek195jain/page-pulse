function LoadingSpinner() {
  return (
    <div className="flex flex-col items-center justify-center py-10">

      <div
        className="
          h-12
          w-12
          rounded-full
          border-4
          border-blue-200
          border-t-blue-600
          animate-spin
        "
      />

      <p className="mt-4 text-slate-600 font-medium">
        Auditing website...
      </p>

    </div>
  );
}

export default LoadingSpinner;