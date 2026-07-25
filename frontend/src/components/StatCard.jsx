function StatCard({
    icon,
    label,
    value,
    valueColor = "text-slate-800"
}) {
    return (
        <div
            className="
                bg-slate-50
                border
                border-slate-200
                rounded-xl
                p-5
                transition-all
                duration-300
                hover:shadow-lg
                hover:-translate-y-1
            "
        >

            <div className="flex items-center gap-3">

                <div className="text-2xl text-blue-600">
                    {icon}
                </div>

                <div>

                    <p className="text-sm text-slate-500">
                        {label}
                    </p>

                    <h3 className={`text-2xl font-bold mt-1 ${valueColor}`}>
                        {value}
                    </h3>

                </div>

            </div>

        </div>
    );
}

export default StatCard;